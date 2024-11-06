# xigemajia_kingdom_1_0_0
新人编写的一款Android精灵对战游戏，目前有十个精灵单位，界面粗糙，战斗机制丰富
（没有采取传统的mvc架构）【哭】
中间包含四个文件夹，“entity”、“fight_about”、“system”、“tool”
与用户交互的view层统一为“system层”，即将处理数据的controller层转变为“tool层”，使得它们变成了一个个可以分解、可以迭代、可以重复的独立单元
entity层包含sprite、skill等实体，而fight_about层仅仅关于两个精灵在一轮对打中用到的函数
相比起过往的精灵对战游戏，本篇在机制上作出巨大创新
比如两个精灵之间的战斗，这两位的完整过程称作“fight”，一回合称作“round”，而一个技能触发给另一个精灵称作“to”
利用这个设计，两个精灵在“迷惑”中可以交换技能、使“round”颠倒，也可以在“to”的过程中进行迭代、反复抛出同一个技能，对对方造成多次伤害，更可以在过程中改变属性、使得每个“to”打出不同属性的伤害，极大提升了可玩度
目前共有9个精灵，欢迎参与编撰和贡献

——若您对具体的部分有疑问——
请查看每一个文件夹内，每一部分都有详细的说明

——若您想要使用这个项目——
您最好在自己的项目里复制这些类，因为这个项目只有java代码部分、不包括那些图片资源和依赖库
导入自己的Android项目后，请找到system里的outputsystem，根据您的需要改变文字的输出方式即可

——若您有任何问题——
可以在社区上为我留下您的宝贵评论，或者联系我的邮箱18672972829@qq.com

——Android Studio导入过程——
点击“新建”->“导入”，将每个类名核对，并对应修改manifest中主类名为“.main”
根据建立xml文件，所需的组件如下：
Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    ScrollView sc;
    EditText txt;
    LinearLayout lin;
根据需要自调整组件位置，然后点击运行即可
