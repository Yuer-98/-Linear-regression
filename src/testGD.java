import java.util.ArrayList;
import java.util.List;

public class testGD {
    public static void main(String args[]) throws Exception{
        test1();
        //加了一个比较大的样本，学习率不够小了，无法收敛
        test2();
        //降低了学习率，收敛了
        test3();
        //把学习率降到非常低试试
        test4();
    }

    /**正常测试*/
    public static void test1() throws Exception{
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        x.add(1.0);
        y.add(1.0);
        x.add(2.0);
        y.add(2.0);
        x.add(7.2);
        y.add(8.2);
        x.add(10.2);
        y.add(9.2);
        x.add(3.2);
        y.add(3.2);
        x.add(6.2);
        y.add(6.7);
        x.add(11.2);
        y.add(10.9);
        x.add(20.2);
        y.add(20.9);
        System.out.println("θ0 和 θ1 的值为" + GradientDescent.createModel(0.02, x, y));
        System.out.println("100的预测值为" + GradientDescent.getPrediction(100));
    }

    /**学习率不够低无法收敛*/
    public static void test2() throws Exception{
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        x.add(1.0);
        y.add(1.0);
        x.add(2.0);
        y.add(2.0);
        x.add(7.2);
        y.add(8.2);
        x.add(10.2);
        y.add(9.2);
        x.add(3.2);
        y.add(3.2);
        x.add(6.2);
        y.add(6.7);
        x.add(11.2);
        y.add(10.9);
        x.add(20.2);
        y.add(20.9);
        /**这里两个较大的数据，再配上过大的学习率，会导致不能收敛！*/
        x.add(86.2);
        y.add(86.7);
        System.out.println("θ0 和 θ1 的值为" + GradientDescent.createModel(0.02, x, y));
        System.out.println("100的预测值为" + GradientDescent.getPrediction(100));
    }

    /**调低学习率来收敛*/
    public static void test3() throws Exception{
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        x.add(1.0);
        y.add(1.0);
        x.add(2.0);
        y.add(2.0);
        x.add(7.2);
        y.add(8.2);
        x.add(10.2);
        y.add(9.2);
        x.add(3.2);
        y.add(3.2);
        x.add(6.2);
        y.add(6.7);
        x.add(11.2);
        y.add(10.9);
        x.add(20.2);
        y.add(20.9);
        /**把学习率降到0.002，就能收敛了*/
        x.add(86.2);
        y.add(86.7);
        System.out.println("θ0 和 θ1 的值为" + GradientDescent.createModel(0.002, x, y));
        System.out.println("100的预测值为" + GradientDescent.getPrediction(100));
    }

    /**测试把学习率调到特别低*/
    public static void test4() throws Exception{
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        x.add(1.0);
        y.add(1.0);
        x.add(2.0);
        y.add(2.0);
        x.add(7.2);
        y.add(8.2);
        x.add(10.2);
        y.add(9.2);
        x.add(3.2);
        y.add(3.2);
        x.add(6.2);
        y.add(6.7);
        x.add(11.2);
        y.add(10.9);
        x.add(20.2);
        y.add(20.9);
        /**把学习率降到0.002，就能收敛了*/
        x.add(86.2);
        y.add(86.7);
        System.out.println("θ0 和 θ1 的值为" + GradientDescent.createModel(0.00002, x, y));
        System.out.println("100的预测值为" + GradientDescent.getPrediction(100));
    }
}