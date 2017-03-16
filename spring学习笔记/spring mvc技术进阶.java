一.使用InitBinder来处理Date类型的参数
//the parameter was converted in initBinder
  @RequestMapping("/date")
  public String date(Date date){
    System.out.println(date);
    return "hello";
  }
  //At the time of initialization,convert the type "String" to type "date"
  @InitBinder
  public void initBinder(ServletRequestDataBinder binder){
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
        true));
  }
 二.向前台传递参数
//pass the parameters to front-end
@RequestMapping("/show")
public String showPerson(Map<String,Object> map){
  Person p =new Person();
  map.put("p", p);
  p.setAge(20);
  p.setName("jayjay");
  return "show";
}
三.使用Ajax调用
//pass the parameters to front-end using ajax
    @RequestMapping("/getPerson")
    public void getPerson(String name,PrintWriter pw){
        pw.write("hello,"+name);        
    }
    @RequestMapping("/name")
    public String sayHello(){
        return "name";
    }

    $(function(){
              $("#btn").click(function(){
                  $.post("mvc/getPerson",{name:$("#name").val()},function(data){
                      alert(data);
                  });
              });
          });
四.在Controller中使用redirect方式处理请求,有两种方法
//redirect 
    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:hello";
    }
五.文件上传
	1.<bean id="multipartResolver"  class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="102400000"></property>
    </bean>
    2.@RequestMapping(value="/upload",method=RequestMethod.POST)
		public String upload(HttpServletRequest req) throws Exception{
		    MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
		    MultipartFile file = mreq.getFile("file");
		    String fileName = file.getOriginalFilename();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");	
		    FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/")+
		      "upload/"+sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.')));
		    fos.write(file.getBytes());
		    fos.flush();
		    fos.close();
		    return "hello";
		}
	3.前台form表单

	<form action="mvc/upload" method="post" enctype="multipart/form-data">
          <input type="file" name="file"><br>
          <input type="submit" value="submit">
      </form>
六.参数除了自动注入，还可以通过注解重命名
	使用@RequestParam注解指定参数的name
	@Controller
	@RequestMapping("/test")
	public class mvcController1 {
	    @RequestMapping(value="/param")
	    public String testRequestParam(@RequestParam(value="id") Integer id,
	            @RequestParam(value="name")String name){
	        System.out.println(id+" "+name);
	        return "/hello";
	    }    
	}
七.RESTFul风格的SringMVC：动态url
      @Controller
      @RequestMapping("/rest")
      public class RestController {
        @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
        public String get(@PathVariable("id") Integer id){
          System.out.println("get"+id);
          return "/hello";
        }
        @RequestMapping(value="/user/{id}",method=RequestMethod.POST)
        public String post(@PathVariable("id") Integer id){
          System.out.println("post"+id);
          return "/hello";
        }
      }
八.返回json
  1.导入jackson-annotation，jackson-databind，jackson-core三个jar包
  2.java代码
    @Controller
    @RequestMapping("/json")
    public class jsonController {
      @ResponseBody
      @RequestMapping("/user")
      public  User get(){
        User u = new User();
        u.setId(1);
        u.setName("jayjay");
        u.setBirth(new Date());
        return u;
      }
    } 
九.自定义拦截器 
    1.创建一个MyInterceptor类，并实现HandlerInterceptor接口

    public class MyInterceptor implements HandlerInterceptor {
        @Override
        public void afterCompletion(HttpServletRequest arg0,
          HttpServletResponse arg1, Object arg2, Exception arg3)
          throws Exception {
      System.out.println("afterCompletion");
        }
        @Override
        public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
          Object arg2, ModelAndView arg3) throws Exception {
      System.out.println("postHandle");
        }
        @Override
        public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
          Object arg2) throws Exception {
      System.out.println("preHandle");
      return true;
        }
    }
    2.在SpringMVC的配置文件中配置

    <!-- interceptor setting -->
        <mvc:interceptors>
            <mvc:interceptor>
                <mvc:mapping path="/mvc/**"/>
                <bean class="test.SpringMVC.Interceptor.MyInterceptor"></bean>
            </mvc:interceptor>        
        </mvc:interceptors>