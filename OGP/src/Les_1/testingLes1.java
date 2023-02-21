package Les_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testingLes1 {

	@Test
	void test() {
		int[] xs = {0,5,-1,3,2,7};
		int[] cs1 = {-1,0,2,3,5,7};
	    Les1.insertionSort(xs);
	    for (int i = 0; i < xs.length; i++)
	       assert xs[i] == cs1[i];
	    int [] ys = {0};
	    int [] cs2 = {0};
	    Les1.insertionSort(ys);
	    for (int i = 0; i < ys.length; i++)
		       assert ys[i] == cs2[i];
	    int[] zs = {525,796,812,291,747,864,44,573,700,842,475,312,914,187,868,129,734,608,154,173,420,46,229,879,673,
	    		833,233,796,559,464,330,581,349,777,605,290,825,48,7,670,189,596,156,459,822,303,983,290,38,556};
	    int[] cs3 = {7,38,44,46,48,129,154,156,173,187,189,229,233,290,290,291,303,312,330,349,420,459,464,475,525,556,
	    		559,573,581,596,605,608,670,673,700,734,747,777,796,796,812,822,825,833,842,864,868,879,914,983};
	    Les1.insertionSort(zs);
	    for (int i = 0; i < zs.length; i++)
		       assert zs[i] == cs3[i];
	}

}
