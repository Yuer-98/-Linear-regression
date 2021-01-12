import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class GradientDescent {
    private static Logger GDLogger = Logger.getLogger("GDLogger");
    private static int maxTimes = 1000000;
    private static double p0 = 0;
    private static double p1 = 0;

    //根据输入的数据集和学习率构建模型
    public static List<Double> createModel(double a, List<Double> x, List<Double> y) throws Exception{
        //这里p0和p1的值必须初始化一下，不然第二次运行createModel时，会保留上次运行的值
        //因为p0和p1的值是在类体里静态初始化的，不是在构造函数
       p0 = 0;
        p1 = 0;
        List<Double> ans = new ArrayList<>();
        if(x.size()!=y.size()){
            GDLogger.warning("x参数个数与y参数个数不同");
            throw new Exception("参数个数不匹配");
        }
        int m = x.size();
        int times = 0;
        //这里不能和p0、p1一样，那样就直接收敛了
        double preP0 = 1;
        double preP1 = 1;
        //当执行maxTimes次时或者满足收敛条件时，都会跳出
        while(times<maxTimes&&(Math.abs(preP0-p0)>0.00001||Math.abs(preP1-p1)>0.00001)){
            preP0 = p0;
            preP1 = p1;
            double term0 = 0;
            double term1 = 0;
            for(int i=0; i<m; i++){
                term0 += p0 + p1 * x.get(i) - y.get(i);
                term1 += (p0 + p1 * x.get(i) - y.get(i)) * x.get(i);
            }
            //同时更新
            p0 = preP0 - (a/m) * term0;
            p1 = preP1 - (a/m) * term1;
            times++;
        }
        ans.add(p0);
        ans.add(p1);
        GDLogger.info("执行了" + times + "次");
        return ans;
    }

    //构建模型后，根据输入x值预测y值
    public static double getPrediction(int x){
        return p0 + p1 * x;
    }
}