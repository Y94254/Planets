public class Planet {
    double xxPos;//行星当前的x位置
    double yyPos;//行星当前的y位置
    double xxVel;//行星在 x 方向上的当前速度
    double yyVel;//行星在 y 方向上的当前速度
    double mass;//地球的质量
    String imgFileName;//与描绘行星的图像对应的文件的名称
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
           this.imgFileName=p.imgFileName;//初始化数据
        this.xxPos=p.xxPos;;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
    }
    public double calcDistance(Planet star){//构造方法计算两个行星之间的距离
    double r=(double)(star.xxPos-this.xxPos)* (star.xxPos-this.xxPos)+(star.yyPos-this.yyPos)*(star.yyPos-this.yyPos);
    r=Math.sqrt(r);
    return r;
    }
    public double calcForceExertedBy(Planet star){//构造方法计算两行星之间的力
        double F=(double)(6.67e-11*star.mass*this.mass)/(calcDistance(star)*calcDistance(star));
        return F;
    }
    public double calcForceExertedByX(Planet star){//构造方法计算一个行星对另一个行星在x轴上的作用力
        double Fx=(double)((star.xxPos-this.xxPos)*calcForceExertedBy(star))/calcDistance(star);
        return Fx;
    }
    public double calcForceExertedByY(Planet star){//构造方法计算一个行星对另一个行星在y轴上的作用力
        double Fy=(double)((star.yyPos-this.yyPos)*calcForceExertedBy(star))/calcDistance(star);
        return Fy;
    }
	public double calcNetForceExertedByX(Planet...Planets){//
		double FnetX=0;//创建变量用于后续存储fnet的值
		for(int i=0;i<Planets.length;i++)//用for循环将数组中各个星球的x轴方向的力进行求和
			{
				if(this.equals(Planets[i]))continue;
		 FnetX +=(double)calcForceExertedByX(Planets[i]);
			}
			return FnetX;
	}		
	public double calcNetForceExertedByY(Planet...Planets){//
		double FnetY=0;
	for(int i=0;i<Planets.length;i++)
			{
				if(this.equals(Planets[i]))continue;
	FnetY +=(double)calcForceExertedByY(Planets[i]);
			}
			return FnetY;
	}
	public void update(double dt,double fX,double fY){
		double anetx=(double)fX/this.mass;
		double anety=(double)fY/this.mass;
			this.xxVel=this.xxVel+anetx*dt;
			this.yyVel=this.yyVel+anety*dt;
			this.xxPos=this.xxPos+this.xxVel*dt;
			this.yyPos=this.yyPos+this.yyVel*dt;
	}
	public void drawPlanets(){
	//StdDraw.enableDoubleBuffering();
		StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
	StdDraw.show();
	}	
}
