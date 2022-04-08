//import java.util.Scanner;
public class NBody{
	public static void main(String[]args){
		//Scanner sc=new Scanner(System.in);
	/*double T=sc.nextDouble();
	double dt=sc.nextDouble();
	String fileName=sc.next();*/
	
	/*double T=157788000.0;
	double dt=25000.0;
	String fileName="data/planets.txt";*/
	double T =  Double.parseDouble(args[0]);
	double dt=  Double .parseDouble(args[1]);
	String fileName=args[2];
		StdDraw.enableDoubleBuffering();
	     StdDraw.setXscale(-readRadius(fileName),readRadius(fileName));
						StdDraw.setYscale(-readRadius(fileName),readRadius(fileName));
	StdDraw.picture(0.5, 0.5,"images/starfield.jpg" );
	StdDraw.show();
	Planet Planets[]=readPlanets(fileName);
	for(int i=0;i<5;i++){
			Planets[i].drawPlanets();	
							}//java NBody 157788000.0 25000.0 data/planets.txt
	for(int j=0;j<=T;j+=dt){//创建动画
		
				double[] xForce=new double[5];
				double[] yForce=new double[5];
					for(int i=0;i<5;i++){
					xForce[i]=Planets[i].calcNetForceExertedByX(Planets);
					yForce[i]=Planets[i].calcNetForceExertedByY(Planets);
							Planets[i].update(dt,xForce[i],yForce[i]);
							
										}
	
	StdDraw.enableDoubleBuffering();
	     
	StdDraw.picture(0.5, 0.5,"images/starfield.jpg" );
	/*for(int i=0;i<5;i++){
			Planets[i].drawPlanets();	
							}*/
	for(int i=0;i<5;i++){
			Planets[i].drawPlanets();	
							}
	StdDraw.show();
	StdDraw.pause(1);//将动画暂停10毫秒
							}
							StdOut.printf("%d\n", Planets.length);
StdOut.printf("%.2e\n", readRadius(fileName));
for (int i = 0; i < Planets.length; i += 1) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                  Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
											}
												}
		public static double readRadius(String file){
			In in = new In( file);
			int N=in.readInt();
			double R=in.readDouble();
				return R;
		} 
	
		public static Planet[] readPlanets(String file){
			In in = new In( file);
			int N=in.readInt();
			double R=in.readDouble();
		Planet p[]=new Planet[5];//创建一个Planet类型的数组用于存放数据
		for(int i=0;i<5;i++){
		Planet Q=new Planet(0,0,0,0,0,"txt");//创建一个Planet类型的数据用于过度数据
		Q.xxPos=in.readDouble();
		Q.yyPos=in.readDouble();
		Q.xxVel=in.readDouble();
		Q.yyVel=in.readDouble();
		Q.mass=in.readDouble();
		Q.imgFileName=in.readString();
		p[i]=Q;
			}
		return p;
		}
		
			
		
	}