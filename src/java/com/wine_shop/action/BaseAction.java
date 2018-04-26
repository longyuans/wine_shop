package com.wine_shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wine_shop.utils.EmailUtil;
import com.wine_shop.utils.FileUpload;
import com.wine_shop.utils.MessageUtil;
import com.wine_shop.wineService.*;
import org.apache.struts2.interceptor.*;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
/*
 * Struts执行流程：先创建Action，再调用拦截器，拦截器访问成功再调用Action的方法
 * 在项目启动的时候Struts的过滤器，已经把相应的内置对象，和内置对象对应的Map存储到了ActionContext和值栈中
 * 如果实现了相应的xxxAware接口，就会从ActionContext中获取相应的Map进行传入。实现这个的拦截器为：servletConfig
 * servletConfig：有如下代码：判断当前实现什么接口，则会注入相应的对象
 * if (action instanceof ApplicationAware) {
            ((ApplicationAware) action).setApplication(context.getApplication());
        }

   if (action instanceof SessionAware) {
            ((SessionAware) action).setSession(context.getSession());
        }

   if (action instanceof RequestAware) {
            ((RequestAware) action).setRequest((Map) context.get("request"));
        }
 */
@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware,ApplicationAware,ModelDriven<T> {

    //获取要删除的ids，要有get和set方法
    //流是用来想前台返回数据的，这个数据是让struts获取的，然后通过流的形式传到前台，所以实现get方法即可
    protected String ids;
    protected InputStream inputStream;

    //page和rows和分页有关，pageMap存放查询的数据，然后打包成json格式用的
    //page和rows实现get和set方法，pageMap只需要实现get方法即可，因为pageMap不是接收前台参数的，是让struts获取的
    protected Integer page;
    protected Integer rows;
    protected Map<String, Object> pageMap = null;

    @Resource
    protected ICategoryDetailService categoryDetailService;
    @Resource
    protected IChateauService chateauService;
    @Resource
    protected IOrderService orderService;
    @Resource
    protected IPriceRankService priceRankService;
    @Resource
    protected IProductService productService;
    @Resource
    protected IReceiverService receiverService;
    @Resource
    protected IReportProductService reportProductService;
    @Resource
    protected IReportService reportService;
    @Resource
    protected IUserService userService;
    @Resource
    protected ICategoriesService categoriesService;
    @Resource
    protected IOderLineService oderLineService;
    /*@Resource
    protected MessageUtil messageUtil;
    @Resource
    protected EmailUtil emailUtil;*/
   /* //上传文件工具类
    @Resource
    protected FileUpload fileUpload;*/

    //域对象
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Map<String,Object> application;
    protected Map<String,Object> session;

    //ModelDriven
    protected T model;
    @Override
    public T getModel() {
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class clazz = (Class)type.getActualTypeArguments()[0];
        try {
            model = (T)clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return model;
    }

    //get和set方法
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getRows() {
        return rows;
    }
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Map<String, Object> getPageMap() {
        System.out.println("--getPage--");
        return pageMap;
    }
    public String getIds() {
        return ids;
    }
    public void setIds(String ids) {
        this.ids = ids;
    }
    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
