public class Planet {
    double xxPos;//���ǵ�ǰ��xλ��
    double yyPos;//���ǵ�ǰ��yλ��
    double xxVel;//������ x �����ϵĵ�ǰ�ٶ�
    double yyVel;//������ y �����ϵĵ�ǰ�ٶ�
    double mass;//���������
    String imgFileName;//��������ǵ�ͼ���Ӧ���ļ�������
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
           this.imgFileName=p.imgFileName;//��ʼ������
        this.xxPos=p.xxPos;;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
    }
    public double calcDistance(Planet star){//���췽��������������֮��ľ���
    double r=(double)(star.xxPos-this.xxPos)* (star.xxPos-this.xxPos)+(star.yyPos-this.yyPos)*(star.yyPos-this.yyPos);
    r=Math.sqrt(r);
    return r;
    }
    public double calcForceExertedBy(Planet star){//���췽������������֮�����
        double F=(double)(6.67e-11*star.mass*this.mass)/(calcDistance(star)*calcDistance(star));
        return F;
    }
    public double calcForceExertedByX(Planet star){//���췽������һ�����Ƕ���һ��������x���ϵ�������
        double Fx=(double)((star.xxPos-this.xxPos)*calcForceExertedBy(star))/calcDistance(star);
        return Fx;
    }
    public double calcForceExertedByY(Planet star){//���췽������һ�����Ƕ���һ��������y���ϵ�������
        double Fy=(double)((star.yyPos-this.yyPos)*calcForceExertedBy(star))/calcDistance(star);
        return Fy;
    }
	public double calcNetForceExertedByX(Planet...Planets){//
		double FnetX=0;//�����������ں����洢fnet��ֵ
		for(int i=0;i<Planets.length;i++)//��forѭ���������и��������x�᷽������������
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
