// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Diagram{

    public Diagram(){
    }
    public double Area(){
        return 0;
    }//计算面积

    public double permeter(){
        return 0;
    }//计算周长
    public void compareArea(Diagram diagram){
        if(diagram.Area()>Area()){
            System.out.println("该形状的面积小于比较的形状面积");
        }
        else if(diagram.Area()==Area()) System.out.println("该形状的面积等于比较形状");
        else System.out.println("该形状的面积大于比较形状");
    }//比较两个形状的面积大小
    public void comparePermeter(Diagram diagram){
        if(diagram.permeter()>permeter()){
            System.out.println("该形状的周长小于比较的形状周长");
        }
        else if(diagram.permeter()==permeter()) System.out.println("该形状的周长等于比较周长");
        else System.out.println("该形状的周长大于比较形状周长");
    }//比较两个形状的周长大小


}
class Triangle extends Diagram{
    double a,b,c;
    //String dia;
    public Triangle(double a,double b,double c){
        super();
        this.a=a;
        this.b=b;
        this.c=c;
        //this.dia="Triangle";
        if(!Judgement()){
            System.out.println("该三角形不存在");
        }
    }
    public boolean Judgement(){
        if(a*a+b*b<=c*c||a*a+c*c<=b*b||b*b+c*c<=a*a){
            return  false;
        }
        return true;
    }//判断输入的三条边能否构成三角形
    public double getA(){ return a;}

    /*public String getDia() {
        return dia;
    }*/


    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double Area() {
        if(!Judgement()){
            System.out.println("该三角形不存在");
            return 0;
        }
        double cos=(a*a+b*b-c*c)/(2*a*b);
        double sin=Math.sqrt(1-cos*cos);
        return a*b*sin/2;
    }//覆盖父类求面积的方法；

    @Override
    public double permeter() {
        if(!Judgement()){
            System.out.println("该三角形不存在");
            return 0;
        }
        return a+b+c;
    }//覆盖父类求周长的方法；

    @Override
    public String toString() {
        String string="三角形的三边长为："+a+","+b+","+c;
        if(!Judgement()){
            string+="\n该三边不能构成三角形！";
        }else{
            string+="\n三角形的周长为:"+permeter()+"\n三角形的面积为："+Area();
        }
        return string;
    }//覆盖toString函数输出相关内容


}
class Rectangle extends Diagram{
    double a,b;
    Rectangle(double a,double b){
        super();
        this.a=a;
        this.b=b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public double getA() {
        return a;
    }

    @Override
    public double Area() {
        return a*b;
    }//覆盖求面积

    @Override
    public double permeter() {
        return 2*(a+b);
    }//覆盖求周长

    @Override
    public String toString() {
        String string ="矩形的长，宽为:"+a+","+b+"\n矩形的周长为:"+permeter()+"\n矩形的面积为:"+Area();
        return string;
    }//覆盖toString方法
}

class Circle extends Diagram{
    double r;
    public Circle(double r){
        super();
        this.r=r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    @Override
    public double permeter() {
        return 2*r*Math.PI;
    }//覆盖求周长

    @Override
    public double Area() {
        return r*r*Math.PI;
    }//覆盖求面积

    @Override
    public String toString() {
        String string="圆的半径为:"+r+"\n圆的周长为:"+permeter()+"\n圆的面积为:"+Area();
        return string;
    }//覆盖toString()，显示该类对象相关信息；
}
public class Main {
    public static void main(String[] args) {
        Diagram triangle=new Triangle(3,4,4);
        Diagram rectangle=new Rectangle(4,5);
        Diagram circle=new Circle(3);
        System.out.println(triangle);
        System.out.println(rectangle);
        System.out.println(circle);
        triangle.compareArea(rectangle);
        triangle.comparePermeter(circle);
    }
}