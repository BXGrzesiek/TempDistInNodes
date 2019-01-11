import java.lang.Math;

public class Calculations extends GlobalData
{
    double J=0;
    double J_1=0;
    double J_2=0;
    double J_3=0;
    double J_4=0;
    int t_1=100;
    int t_2=300;
    int t_3=400;
    int t_inf=400;

    double powT_1 = Math.pow(t_1, 2);       //1000
    double powT_2 = Math.pow(t_2, 2);       //9000
    double powT_3 = Math.pow(t_3, 2);       //16000
    double powT_inf = Math.pow(t_inf, 2);   //16000

    void Calculations()
    {
        J_1 = ((c/2)*(powT_1)-2*(t_1*t_2)+(powT_2));
        J_2 = ((c/2)*(powT_2)-2*(t_2*t_3)+(powT_3));
        J_3 = (q*S*t_1);
        J_4 = (((alfa*S)/2)*(powT_3)-2*(t_3*t_inf)+(powT_inf));
        J=J_1+J_2+J_3+J_4;
        System.out.println(J);
    }
}