package test;

import com.werson.cube.RotateImpl;
import org.junit.*;

import java.util.Arrays;

/**
 * Created by wersom on 2017/10/13 0013.
 */
public class MagicCubeTest {

    private static String[][] magicCube = {{"蓝","蓝","蓝","蓝","绿","蓝","蓝","蓝","蓝"},
            {"橙","橙","橙","橙","红","橙","橙","橙","橙"},
            {"绿","绿","绿","绿","蓝","绿","绿","绿","绿"},
            {"红","红","红","红","橙","红","红","红","红"},
            {"白","白","白","白","白","白","白","白","白"},
            {"黄","黄","黄","黄","黄","黄","黄","黄","黄"},};
    private static RotateImpl rotateImpl = new RotateImpl();

    @Test
    public void row1TurnRightTest(){
        System.out.println("第一行右转");
        rotateImpl.row1TurnRight(magicCube);
    }

    @Test
    public void col1TurnDownTest(){
        System.out.println("第一列下转");
        rotateImpl.col1TurnDown(magicCube);
    }

    @Test
    public void col4TurnDownTest(){
        System.out.println("第四列下转");
        rotateImpl.col4TurnDown(magicCube);
    }

    @After
    public void printMagicCube(){
        for(String[] v : magicCube){
            System.out.println(Arrays.toString(v));
        }
    }
}
