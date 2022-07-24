/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 24/07/2022 12:11:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banji
-- ----------------------------
DROP TABLE IF EXISTS `banji`;
CREATE TABLE `banji`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_banji_banji_1`(`tno`) USING BTREE,
  CONSTRAINT `fk_banji_1` FOREIGN KEY (`tno`) REFERENCES `teacher` (`tno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of banji
-- ----------------------------
INSERT INTO `banji` VALUES (1, '无', '无');

-- ----------------------------
-- Table structure for dajuanitem
-- ----------------------------
DROP TABLE IF EXISTS `dajuanitem`;
CREATE TABLE `dajuanitem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `daan` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `shijuanid` int(11) NULL DEFAULT NULL,
  `defen` int(11) NULL DEFAULT NULL,
  `tihao` int(11) NULL DEFAULT NULL,
  `qtype` int(11) NULL DEFAULT NULL,
  `fenshu` int(11) NULL DEFAULT NULL,
  `stno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `submittime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_dajuanitem_dajuanitem_1`(`shijuanid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of dajuanitem
-- ----------------------------

-- ----------------------------
-- Table structure for examlog
-- ----------------------------
DROP TABLE IF EXISTS `examlog`;
CREATE TABLE `examlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kstime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '开始答卷时间',
  `sjid` int(11) NULL DEFAULT NULL,
  `stno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kmid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_examlog_1`(`sjid`) USING BTREE,
  INDEX `fk_examlog_2`(`tno`) USING BTREE,
  CONSTRAINT `fk_examlog_1` FOREIGN KEY (`sjid`) REFERENCES `shijuan` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_examlog_2` FOREIGN KEY (`tno`) REFERENCES `student` (`stno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of examlog
-- ----------------------------

-- ----------------------------
-- Table structure for jianda
-- ----------------------------
DROP TABLE IF EXISTS `jianda`;
CREATE TABLE `jianda`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `daan` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `kmid` int(11) NULL DEFAULT NULL,
  `title` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `diffact` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jianda
-- ----------------------------
INSERT INTO `jianda` VALUES (1, '区别一：内存一般指内存条，插在电脑主板上，外存一般是磁性介质，指硬盘，软盘，光盘，U盘等。\r\n区别二：内存只能暂时存储数据，断电就没有了，外存可以永久性存储\r\n区别三：内存一般都不大，比外存小，而外存却可以很大\r\n区别四：内存存储速度比外存快，而外存相对要慢很多\r\n区别五：CPU只能直接访问内存，外存的东西要先存到内存，CPU才能处理', 9, '内存与外存的区别是什么？', 0.8);
INSERT INTO `jianda` VALUES (9, '因为super()和this()是调用的父类或本类的无参构造器, 因为Java不允许调用没有初始化的成员. 只有使用了super()或this()来初始化了对象之后, 才能调用该对象并继续进行后续操作. \nSuper()为什么要定义在第一行? 因为子类的构造器中可能会使用父类的属性或方法, 如果父类都没有被创建, 那么就会导致空指针异常, 因此, super()应先执行, 来创建父类的对象. \nThis()为什么要定义在第一行? 因为如果不定义在第一行, 那么当子类创建对象时, 首先会调用父类的无参构造器, 这时候就创建了一个父类的对象. 然后继续执行, 遇到了this()的时候, 就调用该构造器, 而这个构造器又属于是创建子类的对象, 又需要去调用父类的构造器. 也就是说, 造成了资源的浪费, 和同步不一致的问题. \n不能同时出现, 因为它们两个都要求只能出现在第一行. \nSuper()和this()都是调用构造函数进行初始化, 而初始化的动作需要先完成. ', 9, 'super()或者this():为什么一定要定义在第一行？是否可以同时出现？ \n', 0.5);
INSERT INTO `jianda` VALUES (10, '构造方法的作用是在新建一个对象的时候, 调用构造方法来创建对象. \n\n构造方法和普通方法的区别: \n　　1.普通方法必须有返回值类型修饰符, 而构造方法不能有返回值类型修饰符;\n　　2.构造方法名必须和类名相同\n　　3.普通方法用来定义对象的行为, 而构造方法用来初始化', 9, '构造方法的作用是什么？构造方法和普通方法的区别?', 0.5);
INSERT INTO `jianda` VALUES (11, 'Private: 私有的, 本类中\nPublic: 共有的, 任何位置 \nProtected: 受保护的, 本类, 同一个包和子类中可以访问\n缺省的: 同一个包中', 9, '访问修饰符有哪些？各自的作用范围是什么？', 0.5);
INSERT INTO `jianda` VALUES (12, 'Static的作用是把属性和方法定义为静态的, 可以在不创建对象的时候就调用这些属性和方法. 它只需要初始化一次, 可用来定义不经常改变的属性, 或者是对象的计数器. \n用法? 类名.属性 或 类名.方法名() , 即通过类名直接调用.  \n', 9, 'static的作用和用法?', 0.5);
INSERT INTO `jianda` VALUES (13, '不可以. \nStatic的方法内部职能访问static修饰的属性和方法\n因为普通的属性和方法是依赖于对象的, 只有创建了对象之后, 才能通过对象进行访问. 而此时静态方法是没有创建对象的, 因此就会报异常. ', 9, '是否可以从一个static方法内部发出对非static方法的调用？', 0.5);
INSERT INTO `jianda` VALUES (14, '　　1.一个是针对基本数据类型, 一个针对引用数据类型\n　　2.值传递传递的是值, 引用传递传递的是地址\n　　3.值传递是拷贝了一份新的值给形式参数, 在方法中进行操作不会影响原来的值; 而引用传递的是地址, 两个引用指向同一个地址, 因此方法中改变了这个地址中的数据,那么原来的数据也会改变. ', 9, '值传递和引用传递的区别?', 0.5);
INSERT INTO `jianda` VALUES (15, '继承就是一个类继承另一个类的属性和方法. 继承的优点是可以实现代码的重用, 使组件类型保持一致. Extends关键字, 类只能单继承类, 但可以实现多个接口. 所有类的父类是Object类', 9, '什么继承？继承有什么优点？继承使用什么关键字？继承的特点?继承的限制?一个类可以同时继承多个类吗？所有类的父类是什么？', 0.5);
INSERT INTO `jianda` VALUES (16, '重写是指在继承关系中, 子类重新实现了父类中存在的方法. @Override关键字', 9, '什么是重写？用什么方法可以强制检当前方法是否重写父类方法？', 0.5);
INSERT INTO `jianda` VALUES (17, '多态就是指同一个方法, 不同的实现. 多态分为编译时的多态和运行时的多态, 编译时的多态通过方法的重载实现. 运行时的多态通过方法的重写实现. 多态主要运用于增加程序的灵活性, 增加程序的可扩展性', 9, '什么是多态？多态主要的应用是什么？', 0.5);
INSERT INTO `jianda` VALUES (18, '抽象方法就是使用abstract关键字修饰的方法. \n抽象类是指abstract关键字修饰的类. \nJava抽象类可以有构造函数, \nJava抽象类可以有static方法, \nabstract方法不能用static修饰, 因为抽象方法需要被继承和实现, \n而static修饰的方法是可以通过类名直接访问的, 还没有方法体就被访问逻辑上是不合理的. ', 9, '什么是抽象方法？什么是抽象类？Java抽象类可以有构造函数吗？Java抽象类可以有static方法吗？abstract方法可以用static修饰吗?', 0.5);
INSERT INTO `jianda` VALUES (19, '静态方法不可以被重写. 因为静态方法是在类加载时就被加载到内存中的方法, 在整个运行过程中保持不变, 因而不能重写. \n但非静态方法是在对象实例化才单独申请内存空间, 为每一个实例分配独立的运行内存, 因而可以重写. \nJava抽象类可以包含main方法', 9, '静态方法可以被重写吗？Java抽象类中可以包含main方法吗？\n', 0.5);
INSERT INTO `jianda` VALUES (20, '抽象类是指abstract关键字所修饰的类, 里面可以包含普通方法和抽象方法, 还可以有构造函数和普通属性. \nInterface是接口,里面只能包含常量和抽象方法, 不能有构造方法,普通属性和普通方法, 也不鞥你有main方法,\n抽象类是一个类, 而接口的核心是方法', 9, 'abstract class 和interface的区别?', 0.5);
INSERT INTO `jianda` VALUES (21, '引用是指一个指向引用数据类型地址的指针, 对象是指一个类的实例. \n引用可以指向一个对象, 对象也可以包含多个引用\n对象是引用数据类型, 引用数据类型不仅仅包含对象', 9, '请说说引用和对象？', 0.5);
INSERT INTO `jianda` VALUES (22, '可以, 因为char是两个字节, 而unicode的汉字编码所占用的存储空间就是两个字节', 9, 'char型变量中能不能存贮一个中文汉字?为什么?', 0.5);
INSERT INTO `jianda` VALUES (23, '有, Goto语句在java中作为保留字, 并没有实现它. \n带标号的break, continue局限于循环体中跳转\n带标号的goto可以在一个函数(c语言)中任意跳转\nGoto比带标号的break,continue用法灵活, 正因为太灵活了使程序的逻辑结构变得复杂, 流程不够清晰, 程序的可读性下降\n所以java把goto保留了.', 9, 'Java有没有goto', 0.5);

-- ----------------------------
-- Table structure for kemu
-- ----------------------------
DROP TABLE IF EXISTS `kemu`;
CREATE TABLE `kemu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of kemu
-- ----------------------------
INSERT INTO `kemu` VALUES (9, '数据结构');

-- ----------------------------
-- Table structure for panduan
-- ----------------------------
DROP TABLE IF EXISTS `panduan`;
CREATE TABLE `panduan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `daan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kmid` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `diffact` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of panduan
-- ----------------------------
INSERT INTO `panduan` VALUES (1, '正确', 9, 'Word 2000 提供了“所见即所得”的功能。', 0.5);
INSERT INTO `panduan` VALUES (2, '正确', 9, 'Word 2000保存文档格式时，只能是Word 2000文件类型，不能是其它类型。', 0.5);
INSERT INTO `panduan` VALUES (3, '正确', 9, 'Word 2000 文档中要插入一些特殊符号，必须用区位码方式输入。( )', 0.5);
INSERT INTO `panduan` VALUES (4, '正确', 9, 'Word 2000 既能编辑文稿，又能编辑图片。( )', 0.5);
INSERT INTO `panduan` VALUES (5, '正确', 9, 'Word 2000中没有统计功能。( )', 0.5);
INSERT INTO `panduan` VALUES (6, '错误', 9, '在Word 2000 中如果想把表格转化成文本，只有一步一步地删除表格线。( )', 0.5);
INSERT INTO `panduan` VALUES (7, '错误', 9, '在上网时，  IE  提示错误信息  “403 Forbidden”  ，它表示该页受到保护，禁止访问', 0.6);
INSERT INTO `panduan` VALUES (8, '错误', 9, '计算机的硬件组成可以分为4个层次第一层是网络。 ', 0.6);
INSERT INTO `panduan` VALUES (13, '正确', 9, '用final修饰的变量叫常量', 0.5);
INSERT INTO `panduan` VALUES (14, '正确', 9, '描述对象的两个要素是属性和方法。', 0.5);
INSERT INTO `panduan` VALUES (15, '错误', 9, 'Java支持多重继承', 0.5);
INSERT INTO `panduan` VALUES (16, '错误', 9, '覆盖的同名方法中，子类方法不能比父类方法的访问权限低。', 0.5);
INSERT INTO `panduan` VALUES (17, '错误', 9, '抽象类中能创建对象。', 0.5);
INSERT INTO `panduan` VALUES (18, '正确', 9, '一个类可以实现多接口。', 0.5);
INSERT INTO `panduan` VALUES (19, '错误', 9, 'Unicode码与ASCII码相同。', 0.5);
INSERT INTO `panduan` VALUES (20, '正确', 9, 'Java语言是编译解释型语言。', 0.5);
INSERT INTO `panduan` VALUES (21, '正确', 9, 'Java语言支持类的继承,但只支持类的单继承。', 0.5);
INSERT INTO `panduan` VALUES (22, '错误', 9, '抽象方法没有方法体。', 0.5);
INSERT INTO `panduan` VALUES (23, '错误', 9, '方法的重载是指子类和父类具有相同的名字、相同的参数表，但返回类型可以不相同。', 0.5);
INSERT INTO `panduan` VALUES (24, '正确', 9, '在Java中声明变量时必须指定一个类型。', 0.5);
INSERT INTO `panduan` VALUES (25, '错误', 9, 'Java中，一个类可以有多个直接父类。', 0.5);
INSERT INTO `panduan` VALUES (26, '正确', 9, 'package语句必须放在程序的第一句。', 0.5);
INSERT INTO `panduan` VALUES (27, '正确', 9, '一个类实现一个接口，则该类必须实现接口中的所有方法。', 0.5);
INSERT INTO `panduan` VALUES (28, '正确', 9, 'final类中的属性和方法都必须是final的。', 0.5);
INSERT INTO `panduan` VALUES (29, '错误', 9, '在方法定义中，可能发生的异常都必须用try{} catch ){}捕捉。', 0.5);
INSERT INTO `panduan` VALUES (30, '正确', 9, 'Java 程序一般应当含有 main 方法，因为它是所有 Java 程序执行的入口', 0.5);
INSERT INTO `panduan` VALUES (31, '正确', 9, 'Java 语言的标识符是不区分大小写的。', 0.5);
INSERT INTO `panduan` VALUES (32, '错误', 9, '有时候为了避免引起混淆，构造方法的方法名可以不与所属类名同名。', 0.5);
INSERT INTO `panduan` VALUES (33, '错误', 9, '在java继承机制中，父类中的私有 private）成员不能被子类继承。', 0.5);
INSERT INTO `panduan` VALUES (34, '正确', 9, 'Java的类不允许多重继承，但接口支持多重继承。', 0.5);
INSERT INTO `panduan` VALUES (35, '正确', 9, '一个类中含有几个构造方法，称为构造方法的重载。对于重载的方法，其参数列表可以相同。', 0.5);
INSERT INTO `panduan` VALUES (36, '错误', 9, '在编译Java源程序时，计算机根本不会去识别各个变量名的具体含义，因此命名规范对编写 Java程序而言不是必要的。', 0.5);
INSERT INTO `panduan` VALUES (37, '正确', 9, 'abstract方法只能在abstract类或接口。', 0.5);
INSERT INTO `panduan` VALUES (38, '正确', 9, '成员变量的值会因为对象的不同而不同。', 0.5);
INSERT INTO `panduan` VALUES (39, '正确', 9, 'final 方法不能被覆盖。', 0.5);
INSERT INTO `panduan` VALUES (40, '正确', 9, '抽象类中不能创建对象。', 0.5);
INSERT INTO `panduan` VALUES (41, '错误', 9, '接口中可以包含非静态成员。', 0.5);
INSERT INTO `panduan` VALUES (44, '错误', 9, 'Spring boot不需要服务器就能运行web程序', 0.5);

-- ----------------------------
-- Table structure for paperstate
-- ----------------------------
DROP TABLE IF EXISTS `paperstate`;
CREATE TABLE `paperstate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shijuanid` int(11) NULL DEFAULT NULL,
  `dstate` bit(1) NULL DEFAULT b'0',
  `ystate` bit(1) NULL DEFAULT b'0',
  `stno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_paperstate_1`(`shijuanid`) USING BTREE,
  CONSTRAINT `fk_paperstate_1` FOREIGN KEY (`shijuanid`) REFERENCES `shijuan` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of paperstate
-- ----------------------------

-- ----------------------------
-- Table structure for shijuan
-- ----------------------------
DROP TABLE IF EXISTS `shijuan`;
CREATE TABLE `shijuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kmid` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zongfen` int(11) NULL DEFAULT NULL,
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `starttime` datetime(0) NULL DEFAULT NULL,
  `diffaclt` double NULL DEFAULT NULL COMMENT '难易程度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of shijuan
-- ----------------------------

-- ----------------------------
-- Table structure for shijuanitem
-- ----------------------------
DROP TABLE IF EXISTS `shijuanitem`;
CREATE TABLE `shijuanitem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fenshu` int(11) NULL DEFAULT NULL,
  `shijuanid` int(11) NULL DEFAULT NULL,
  `tihao` int(11) NULL DEFAULT NULL,
  `qtype` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_shijuanitem_shijuanitem_1`(`shijuanid`) USING BTREE,
  CONSTRAINT `fk_shijuanitem_shijuanitem_1` FOREIGN KEY (`shijuanid`) REFERENCES `shijuan` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of shijuanitem
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jiguan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mianmao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tell` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zhuanye` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `stno`) USING BTREE,
  INDEX `stno`(`stno`) USING BTREE,
  INDEX `fk_student_student_1`(`classid`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  CONSTRAINT `fk_student_student_1` FOREIGN KEY (`classid`) REFERENCES `banji` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tell` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sysuser
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jiguan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `xueli` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tell` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zhicheng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jieshao` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`, `tno`) USING BTREE,
  INDEX `tno`(`tno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (6, '无', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tiankong
-- ----------------------------
DROP TABLE IF EXISTS `tiankong`;
CREATE TABLE `tiankong`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `daan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kmid` int(11) NULL DEFAULT NULL,
  `title` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `diffact` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tiankong
-- ----------------------------
INSERT INTO `tiankong` VALUES (1, '123', 9, 'DMA 的数据块传送可分为______、______ 和______ 阶段', 0.5);
INSERT INTO `tiankong` VALUES (2, '20,50', 9, '设n = 16 (不包括符号位)，机器完成一次加和移位各需100ns，则原码一位乘最多需______ ns，补码Booth 算法最多需______ ns ', 0.5);
INSERT INTO `tiankong` VALUES (3, '机器', 9, '计算机唯一能直接执行的语言是______语言\r\n.', 0.5);
INSERT INTO `tiankong` VALUES (6, '7', 9, '在 Java 语言中有定义 int[ ] a = {22,33,44,55,66,77,88},则 a.length = __。', 0.6);
INSERT INTO `tiankong` VALUES (7, '45', 9, ' 在 Java 程序中有如下代码，则输出结果为________。\n\nInteger x=23456;\n\nSystem.out.println(x.toString().substring(2,4));\n\n', 0.6);
INSERT INTO `tiankong` VALUES (8, '3', 9, ' 设 int x=1 , y=2 , z=3 ， 则表达式 y ＋ ＝ (z － － )/( ＋ ＋ x) 的值是__。', 0.6);
INSERT INTO `tiankong` VALUES (9, 'Object', 9, 'java 语言中______是所有类的父类', 0.6);
INSERT INTO `tiankong` VALUES (10, '与平台无关', 9, 'Java 语言采用多种机制来保证可移植性，其中最主要的是______。', 0.5);
INSERT INTO `tiankong` VALUES (11, '公共', 9, '如果 Java 源文件中有多个类，那么只能有一个_________类。', 0.5);
INSERT INTO `tiankong` VALUES (12, 'super.x', 9, '如果子类 A 隐藏了超类 B 的成员变量 x，而类 A 的某个方法 f()要引用类 B 的 x，则引用\n\n\n\n类 B 的 x 的引用代码可以写成__________。', 0.6);

-- ----------------------------
-- Table structure for xuanze
-- ----------------------------
DROP TABLE IF EXISTS `xuanze`;
CREATE TABLE `xuanze`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `choicea` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `choiceb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `choicec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `choiced` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `daan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kmid` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `diffact` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of xuanze
-- ----------------------------
INSERT INTO `xuanze` VALUES (1, 'CPU ', 'CPU  、内存与外存', 'CPU  和内存', 'CPU  、内存与硬盘', 'A', 9, '通常所说的主机是指∶', 0.5);
INSERT INTO `xuanze` VALUES (2, 'ACSII  码', ' BCD  码', '二进制', '十六进制', 'A', 9, '在计算机内部，一切信息的存取、处理和传送的形式是', 0.5);
INSERT INTO `xuanze` VALUES (3, '单片机 ', '组合机', '不装备任何软件的计算机    ', '只安装操作系统的计算机', 'A', 9, '所谓“裸机”是指', 0.5);
INSERT INTO `xuanze` VALUES (4, '程序价格便宜、软件价格昂贵；', '程序是用户自己编写的，而软件是由厂家提供的； ', '程序是用高级语言编写的，而软件是由机器语言编写的', '软件是程序以及开发、  使用和维护所需要的所有', 'D', 9, '软件与程序的区别是∶', 0.5);
INSERT INTO `xuanze` VALUES (5, '所有能够使用的软件', '能被各应用单位共同使用的某种软件 ', '所有微机上都应使用的基本软件', '专门为某一应用目的而编制的软件  ', 'D', 10, '应用软件是指 ', 0.5);
INSERT INTO `xuanze` VALUES (6, '发现源程序中的语法错误   ', '改正源程序中的语法错误 ', '将源程序编译成目标程序', '将某一高级语言程序翻译成另一种高级语言', 'C', 9, '编译程序的功能是', 0.3);
INSERT INTO `xuanze` VALUES (7, '机器语言', '汇编语言', '高级语言', '自然语言', 'A', 9, '可移植性最好的计算机语言是∶', 0.3);
INSERT INTO `xuanze` VALUES (8, '效率  ', '复杂性', '复杂度', '难度', 'C', 9, '算法的计算量的大小称为计算的（    ）', 0.5);
INSERT INTO `xuanze` VALUES (9, '可执行性、可移植性、可扩充性', '可执行性、确定性、有穷性', '确定性、有穷性、稳定性', '易读性、稳定性、安全性', 'B', 9, '计算机算法指的是（1），它必须具备（2） 这三个特性。', 0.5);
INSERT INTO `xuanze` VALUES (10, '程序', '问题求解步骤的描述 ', '要满足五个基本特性', 'A和C. ', 'C', 9, '一个算法应该是（     ）', 0.3);
INSERT INTO `xuanze` VALUES (11, '算法原地工作的含义是指不需要任何额外的辅助空间', '在相同的规模n下，复杂度O(n)的算法在时间上总是优于复杂度O(2n)的算法 ', '所谓时间复杂度是指最坏情况下，估算算法执行时间的一个上界', '同一个算法，实现语言的级别越高，执行效率就越低', 'D', 9, '下面说法错误的是（    ）', 0.3);
INSERT INTO `xuanze` VALUES (12, '循环队列 ', '链表', '哈希表     ', '栈', 'C', 9, '以下与数据的存储结构无关的术语是（    ）', 0.3);
INSERT INTO `xuanze` VALUES (13, '逻辑结构', '选择结构', '循环结构', '顺序结构', 'A', 9, '算法的基本结构中不包括', 0.6);
INSERT INTO `xuanze` VALUES (14, '实现算术运算和逻辑运算', '保存各种指令信息供系统其他部件使用', '分析指令并进行译码   ', '按主频指标规定发出时钟脉冲', 'A', 9, '运算器的主要功能是', 0.6);
INSERT INTO `xuanze` VALUES (15, '高级编程', '计算机', '面向对象', '面向过程', 'C', 9, 'java是面什么语言', 0.6);
INSERT INTO `xuanze` VALUES (16, '解析型高级语言', '计算机语言', '汇编语言', '编程语言', 'A', 9, 'Java是一种什么语言', 0.6);
INSERT INTO `xuanze` VALUES (17, 'u 盘', '内存存储器', '光盘', '固定硬盘', 'B', 9, '下列各存储器中，存取速度最快的一种是()', 0.5);
INSERT INTO `xuanze` VALUES (18, '局域网', '都市网', '广域网', '星型网', 'D', 9, '1.下列哪些计算机网络不是按覆盖地域划分的( )。', 0.5);
INSERT INTO `xuanze` VALUES (19, '军事机构', '政府机构', '教育机构', '商业公司', 'D', 9, '域名中的后缀.com表示机构所属类型为( )', 0.5);
INSERT INTO `xuanze` VALUES (20, '半导体', '电子', '激光', '磁效应', NULL, 9, '光盘是一种利用————技术的存储设备', 0.5);
INSERT INTO `xuanze` VALUES (21, '有利于代码共享，减少主、辅存信息交换量', '充分利用存储器', '充分利用CPU，减少CPU等待时间', '提高实时响应速度', 'D', 9, '在操作系统中引入多道程序设计的目的在于（     ）', 0.5);
INSERT INTO `xuanze` VALUES (22, 'JAVA程序的main方法必须写在类里面', 'JAVA程序中可以有多个main方法', 'JAVA程序中类名必须与文件名一样', 'JAVA程序的main方法中如果只有一条语句，可以不用{}(大括号)括起来', 'A', 9, '下列说法正确的是（）', 0.5);
INSERT INTO `xuanze` VALUES (25, 'then', 'continue', 'java', 'PUBLIC', 'C', 9, '下面选项中，(  )是Java 关键字。', 0.5);
INSERT INTO `xuanze` VALUES (26, 'boolean b=”true”;', 'double x=2.5f;', 'char c=”A”;', 'float y=0.8d;', 'B', 9, '下面语句中，正确的是(  )', 0.5);
INSERT INTO `xuanze` VALUES (27, 'int m=s.indexOf(‘r’)；', 'char c=s.charAt(0)；', 'int n=s.length()；', 'String str=s.append(‘2’);', 'D', 9, '设有定义：String s=“World”;，下列语句错误的是(  )', 0.5);
INSERT INTO `xuanze` VALUES (28, 'private class MyClass extends Object', 'public class myclass extends Object', 'public class MyClass', 'class MyClass extends Object', 'C', 9, '假设在Java 源程序文件“MyClass.java”中只含有一个类，而且这个类必须能够被位于个庞大的软件系统中的所有Java 类访问到，那么下面(  )声明有可能是符合要求的类声明。', 0.5);
INSERT INTO `xuanze` VALUES (29, '与文件目录的层次相同', '与文件的结构相同', '与文件类型相同', '与文件大小相同', 'A', 9, '在Java 中，用package 语句说明一个包时，该包的层次结构必须是( )。', 0.5);
INSERT INTO `xuanze` VALUES (30, '数组是最简单的复合数据类型，是一系列数据的集合', '声明数组时，必须分配内存', '数组的元素可以是值(基本数据类型)、对象或其他数组', '一个数组中的所有值都必须是相同的类型', 'B', 9, '下面关于数组的说法，错误的是( )。', 0.5);
INSERT INTO `xuanze` VALUES (31, 'Java 中的方法参数传递时传值调用，而不是地址调用', '方法体是对方法的实现，包括变量声明和Java 的合法语句', '如果程序定义了一个或多个构造方法，在创建对象时，也可以用系统自  动生成空的构造方法', '类的私有方法不能被其子类直接访问', 'C', 9, '下面关于方法的说法，错误的是(  )', 0.5);
INSERT INTO `xuanze` VALUES (32, '内部类不能有自己的成员方法和成员变量', '内部类可用abstract 修饰定义为抽象类，也可以用private 或protected 定义', '内部类可作为其他类的成员，而且可访问它所在类的成员', '内部类是写在内里面的类', 'A', 9, '下面关于内部类的说法，错误的是(  )。', 0.5);
INSERT INTO `xuanze` VALUES (33, 'ArithmeticException', 'NullPointerException', 'IOException', 'ClassNotFoundException', 'B', 9, '给定如下所示的JAVA代码，则运行时，会产生（）类型的异常\nString s = null; s.concat(\"abc\");', 0.5);
INSERT INTO `xuanze` VALUES (34, '200ok表示请求成功', '400不良请求表示服务器未发现与请求URL匹配内容', '404未发现表示由于语法错误儿导致服务器无法理解请求信息', '500内部服务器错误，无法处理请求', 'D', 9, '.以下HTTP相应状态码的含义描述正确的是（）', 0.5);
INSERT INTO `xuanze` VALUES (35, 'JSP命令', 'JSP Action', ' JSP脚本', 'JSP控件', 'C', 9, 'JSP页面包括哪些元素？（）', 0.5);
INSERT INTO `xuanze` VALUES (36, 'DOM', 'CSS', 'JavaScript', 'XmlHttpRequest', 'A', 9, 'Ajax有四种技术组成：DOM,CSS,JavaScript，XmlHttpRequest，其中控制文档结构的是（）', 0.5);
INSERT INTO `xuanze` VALUES (37, 'HttpSession session=new HttpSession();', 'String haha=session getParameler(:haha”);', 'session.removeAttribute(“haha”);', 'session.setAttribute(:haha:);XmlHttpRequest', 'A', 9, '下面关于session的用法哪些是错误的？（）', 0.6);
INSERT INTO `xuanze` VALUES (38, 'var obj=( );', 'var obj=[ ];', 'var obj=1;', 'var obj={}；', 'A', 9, '以下JavaScipt语句会产生运行错误的是_（）', 0.6);
INSERT INTO `xuanze` VALUES (39, '<% %>', '<% ! %>', ' <%@ %>', '<%=%>', 'B', 9, '在JSP中，下面__（）__块中可以定义一个新类：', 0.6);

SET FOREIGN_KEY_CHECKS = 1;
