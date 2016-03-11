//Inputs: [hr] [m]
/*
Uses a simplified version of the formula:
    h_deg = 60*h + 1/30 * 60 * m
    m_deg = m * 60
    deg_delta = (h_deg - m_deg)%360
*/
public class minhr{
    public static void main(String args[]){
        float hour = Float.valueOf(args[0]);
        float minute = Float.valueOf(args[1]);
        float degree_difference = 30 * hour - 5.5f * minute;
        System.out.println(degree_difference);
    }
}