# EvoWkf
1.概述
取名自Evolutionary，因其主要亮点是高可扩展性
设计阶段充分考虑扩展性
扩展性体现在：
工作流模式可扩展，
工作流实例可扩展，
工作流实例匹配策略可扩展，
结点可扩展，
业务事件可扩展，
事件执行策略可扩展，
路由策略可扩展，

由于高可扩展会带来高灵活度，系统的配置复杂度会随灵活度的提高而提高，这对使用者来说几乎无法操作配置功能，对开发者来说提高了开发难度

为解决这个高灵活度问题，设计中增加了工作流模式、结点模板概念，通过定义一套工作流模式+结点模板可固定住代码层面的配置数据，从而简化了使用者的操作。使用者只需要根据业务选择不同的步骤（与结点模板绑定的结点），设置步骤的执行人员（工作组）。

对于开发者，EvoWKF实现了几种广泛应用的工作流模式，并提供扩展接口。开发者可按自身需求在各个扩展接口设计自定义实现，通过配置调用自定义实现。如果需要开发全新模式的工作流，可合作~

2.演示平台地址http://106.15.93.237/

3.本地开发环境搭建步骤
软件要求：jdk8、tomcat8、mySql5、node.js、vue
(1)evowkf-前台文件夹内是前台源码。evowkf_dev.sql是数据库建表及初始化脚本。src文件夹是后台源码。pom.xml是后台marven工程配置。
(2)修改main.js，axios请求前缀
	默认axios.defaults.baseURL = 'http://localhost/evowkf'
(3)修改config/index.js build发布路径
	默认index: path.resolve(__dirname, 'D:/apache-tomcat-8.5.20/webapps/ROOT/index.html'),
        assetsRoot: path.resolve(__dirname, 'D:/apache-tomcat-8.5.20/webapps/ROOT'),
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
(4)打开命令行，进入evowkf-前台，编译发布前台代码到tomcat的webapps/ROOT内
(5)eclipse导入marven工程
(6)修改evowkf.properties，数据库配置、首页地址、自动还原数据库脚本保存路径
	jdbc.url=jdbc:mysql://localhost:3306/evowkf_dev?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8
	jdbc.username=kool
	jdbc.password=kool
	HOME_URL=http://localhost/
	INIT_DB_SQL_PATH=D:/template/evowkf_dev.sql
(7)修改web.xml 删除以下配置，可关闭自动还原
	<servlet>
    <servlet-name>initDb</servlet-name>
    <servlet-class>
            com.kool.InitDBServlet
        </servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>initDb</servlet-name>
    <url-pattern>/xx</url-pattern>
  </servlet-mapping>
(8)新建数据库evowkf_dev，新建用户kool，密码kool，执行evowkf_dev.sql
(9)编译发布后台到tomcat的webapps下
(10)修改tomcat端口为80，启动tomcat，访问http://localhost

作者邮箱：luyuzjut@163.com
github:kool2017
