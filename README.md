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

对于开发者，EvoWKF实现了几种广泛应用的工作流模式，并提供扩展接口。开发者可按自身需求在各个扩展接口设计自定义实现，通过配置调用自定义实现。

2018-7-18   框架升级。
				RESTFul化改造，请求无状态，删除session内数据存取逻辑，增加请求签名验签功能，增加请求加密解密功能，平台统一的报文格式；
				优化异常，增加AppException异常栈，增加错误码翻译，统一异常日志编码风格，异常日志加入定位标记；
				框架统一管理事务。
				配置文件中数据库连接密码改为密文。
				增加缓存功能，使用ehcache框架。
				统一编码规范。后台action、service、dao、io、bean增删改查分页查询功能由工具生成；前台vue由工具生成
			增加公共业务模块，（暂不开源）
				增加文件上传。
				用户管理功能升级。增加头像、签名、重置密码、修改密码、授权、冻结、解冻、赋予角色。用户分级：超级管理员、管理员、普通用户、游客。
				增加角色管理
				增加角色组管理
				增加菜单管理
				增加请求管理
				增加权限管理。权限分级：超管权限、管理权限、普通权限、游客权限。
				增加3层4级权限控制。授权对象分层：用户、角色、角色组。权限关联菜单、请求。通过授权关联用户与菜单、请求的关系。授权按权限等级用户登记控制可授权用户
				增加计数器管理
				增加错误码管理
				增加参数管理
2.演示平台地址http://47.99.50.88/

3.本地开发环境搭建步骤
软件要求：jdk8、tomcat8、mySql5.7、node.js、vue、maven
(1)evowkf-web文件夹是前台源码。evowkf_dev.sql是数据库建表及初始化脚本。src文件夹是后台源码。pom.xml是后台marven工程配置。
(2)修改main.js，axios请求前缀
	默认axios.defaults.baseURL = '/evowkf'
(3)修改config/index.js build发布路径
	默认index: path.resolve(__dirname, 'D:/apache-tomcat-8.5.20/webapps/ROOT/index.html'),
        assetsRoot: path.resolve(__dirname, 'D:/apache-tomcat-8.5.20/webapps/ROOT'),
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
(4)打开命令行，进入evowkf-web，编译发布前台代码到tomcat的webapps/ROOT内
	npm install
	npm run build
(5)eclipse导入marven工程
(6)修改evowkf.properties，数据库配置、首页地址、自动还原数据库脚本保存路径
	jdbc.url=jdbc:mysql://localhost:3306/evowkf_dev?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8
	jdbc.username=
	jdbc.password=
	INIT_DB_SQL_PATH=D:/evowkf/init.sql
(7)修改web.xml 删除以下配置，可关闭自动还原
	<servlet>
    <servlet-name>initDb</servlet-name>
    <servlet-class>
            com.kool.InitDBServlet
        </servlet-class>
    <load-on-startup>2</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>initDb</servlet-name>
    <url-pattern>/xx</url-pattern>
  </servlet-mapping>
(8)新建数据库evowkf_dev，新建用户evowkf,密码85fg6D#J!991，执行evowkf_dev.sql
	注意：此密码是配置文件中的密码的解密，如果有误或要更换可使用Druid的加密工具ConfigTools重新生成你的密码的密钥对和密文，然后修改配置文件的公钥和密码。
(9)编译发布后台到tomcat的webapps下
(10)修改tomcat端口为80，启动tomcat，访问http://localhost
	注意：如果是本地前后台联调，可以将tomcat端口设置为8080启动，前台npm run dev启动服务端口为80，配置代理将请求映射到localhost:8080

2018-7-18 产品框架升级了一版，暂时删除了用户管理的工作流演示功能，同学们可自行将审批界面的route取消注释，将增加用户action换成增加用户经办。目前正开发工作流配置可视化界面，很快会开源。
		近期接洽了医院的业务，感觉负责公共事业的部门正大力推进数据管理技术，平台在完成工作流改造后会集成kettle，研发数据权限、报表

作者简介：
曾就职于招商银行软件开发中心-招银网络科技，有丰富的大型金融软件平台研发经验
参与负责开发与研发的产品包括：人行ECDS电票交易平台、中远海财务公司财资管理平台、重庆化医财务公司财资管理平台、深能源财务公司财资管理平台、江苏交控财务公司财资管理平台等。
现团队正在筹建科技公司。
主要业务范围：财务管理软件的开发与咨询服务，医疗软件的开发与咨询服务，开源企业级应用框架开发与咨询服务，自动化开发工具的开发与咨询服务，移动支付接口第三方平台开发与咨询服务

邮箱：luyuzjut@163.com
github:kool2017
码云:kool2017
