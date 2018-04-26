package com.wine_shop.action;

import com.wine_shop.bean.Receiver;
import com.wine_shop.bean.User;
import com.wine_shop.wineService.IReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("receiverAction")
@Scope("prototype")
public class ReceiverAction extends  BaseAction<Receiver>{
    @Autowired
    private IReceiverService receiverService;

    public void setReceiverService(IReceiverService receiverService) {
        this.receiverService = receiverService;
    }

    //查询收货人信息
    public String getReceiver(){
        try{
            User user = (User) application.get("user");
            List<Receiver> receivers = receiverService.selectAllReceiverByUserId(user.getId());
            System.out.println("查询receiver"+receivers.size());
            if(receivers.size()>0){
                session.put("receiver", receivers);
            }
            System.out.println("查询所有的receiver，之后跳转到confirm"+"user的id="+user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
    //更新收货人信息
    public String addReceiver(){
        try{
            // 获取收件人填入的信息
            //String name =new String( request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
            String name = request.getParameter("name");
            String address =request.getParameter("address");
            String phone = request.getParameter("phone");
            // 获取当前用户
            User user = (User) application.get("user");
            System.out.println(user);
            // 获取当前用户所有的收货信息
            List<Receiver> receivers = receiverService.selectAllReceiverByUserId(user.getId());
            System.out.println("查询了所有的receiver");
            // 判断是否有信息
            // 判断收货人信息是否有的为空
            boolean flag = false;
            if (("".equals(name) || name == null)
                    && ("".equals(address) || address == null)
                    && ("".equals(phone) || phone == null)) {
                response.sendRedirect("confirm.jsp");
            } else {
                if (receivers.size() > 0) {
                    System.out.println("进入receiver的对比");
                    for (int j = 0; j < receivers.size(); j++) {
                        // 判断当前填入的信息是否和数据库中查询的信心是否相等
                        if (name.equals(receivers.get(j).getName())
                                && address.equals(receivers.get(j).getAddress())
                                && phone.equals(receivers.get(j).getPhone())) {
                            System.out.println("有receiver，并且三个参数相等");
                            session.put("receiver", receivers.get(j));
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        Receiver receiver = new Receiver(name, address, phone, user.getId());
                        receiverService.insertReceiver(receiver);
                        System.out.println("有receiver，但是与新传入的值不同，新插入:"+receiver);
                        session.put("receiver", receiver);
                    }
                } else {
                    System.out.println("准备插入新的receiver");
                    Receiver receiver = new Receiver(name, address, phone, user.getId());
                    receiverService.insertReceiver(receiver);
                    session.put("receiver", receiver);
                    System.out.println("没有receiver，但是新插入了receiver");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
}
