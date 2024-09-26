package griffith;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SkeletonTest {

	@Test
    public void testIsValidWeatherDate_ValidDate() {
        assertTrue(Skeleton.isValidWeatherDate("2024-03-18"));
    }

    @Test
    public void testIsValidWeatherDate_InvalidDate() {
        assertFalse(Skeleton.isValidWeatherDate("InvalidDate"));
    }

    @Test
    public void testIsValidWeatherDate_DateInPast() {
        assertFalse(Skeleton.isValidWeatherDate("2020-01-01"));
    }
	

}
