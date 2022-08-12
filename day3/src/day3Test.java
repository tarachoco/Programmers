import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class day3Test {

    @Test
    public void day3Test(){

        Assert.assertEquals(Solution.solution(5,12),4);
        Assert.assertEquals(Solution.solution(5,24),4);
        Assert.assertEquals(Solution.solution(5,26),4);
        Assert.assertEquals(Solution.solution(5,5),1);
        Assert.assertEquals(Solution.solution(5,25),2);
        Assert.assertEquals(Solution.solution(5,31128),-1);
    }
}