# Aurora-Plugin

## IDEA模型结构

### Application

主要指代的是IDEA这个应用程序本身

### Project

主要代表向导创建的一个新项目,项目的级别要大于模块,主要区分单模块项目和多模项目.

项目相关的核心类和接口:

Project(项目实例)

ProjectRootManager(查询和修改属于项目的根文件和目录的列表。)

ProjectManager(项目管理)

ProjectFileIndex(有关项目中包含的文件的信息,和虚拟文件相关)

项目实例的获取渠道:动作扩展,文件编辑器,模块(这几个比较常用)

### Module(构建项目的基础)

主要代表一个具体的项目单元,比如一个空的模块下面可以创建非常多的小模块,这些模块之间完全独立,可以相互依赖,模块的配置可以继承于项目的配置

处理模块相关的类和接口:


### VirtualFile(虚拟文件)

虚拟文件存在于IDEA运行时期(也就是说是加载到内存中),每个虚拟文件其根本对应的存在的文件,在IDEA中虚拟文件能被多个地方使用而不受影响.

虚拟文件可以被创建,虚拟文件的创建会更改虚拟文件系统,可以被主题消息监听到创建之前和创建之后的动态.

获取虚拟文件的途径:PSI,文档,给定的本地文件路径,动作.

用途:

遍历文件系统、获取文件内容、重命名、移动或删除。应使用 来执行递归迭代，以防止由递归符号链接引起的无限循环
