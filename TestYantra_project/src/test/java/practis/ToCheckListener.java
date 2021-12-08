package practis;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.BaseAnnotationClass;

@Listeners(com.vitiger.comcast.generic_utility.ListnerImplementation.class)
public class ToCheckListener extends BaseAnnotationClass {

    @Test
    public void Tl() {
    	System.out.println("listner");
    	Assert.fail();
    }
}
