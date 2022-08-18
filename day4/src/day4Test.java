import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class day4Test {

    @Test
    public void day4Test(){

        Assert.assertEquals(Solution.solution(new int[]{1, 2, 3, 1}), 4);
        Assert.assertEquals(Solution.solution(new int[]{1,1,4,1,4}), 8);
        Assert.assertEquals(Solution.solution(new int[]{1000,0,0,1000,0,0,1000,0,0,1000}), 3000);
        Assert.assertEquals(Solution.solution(new int[]{1000,1,0,1,2,1000,0}), 2001);
        Assert.assertEquals(Solution.solution(new int[]{1000,0,0,0,0,1000,0,0,0,0,0,1000}), 2000);
        Assert.assertEquals(Solution.solution(new int[]{1,2,3,4,5,6,7,8,9,10}), 30);
        Assert.assertEquals(Solution.solution(new int[]{0,0,0,0,100,0,0,100,0,0,1,1}), 201);
        Assert.assertEquals(Solution.solution(new int[]{11,0,2,5,100,100,85,1}), 198);
        Assert.assertEquals(Solution.solution(new int[]{1,2,3}), 3);
        Assert.assertEquals(Solution.solution(new int[]{91,90,5,7,5,7}), 104);
        Assert.assertEquals(Solution.solution(new int[]{90,0,0,95,1,1}), 185);
    }

}