package logintests;

import org.junit.Test;

import com.sapient.trading.repos.UserRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;




public class LoginTests {
	@Test
    public void testfindAllUser() {
		 UserRepository mockedRepo = mock(UserRepository.class);
		 when(mockedRepo.findAllUsers("430","matt")).thenReturn(1);

	        // use mock in test....
	        assertEquals(mockedRepo.findAllUsers("430","matt"), 1);
	        
	     when(mockedRepo.findAllUsers("430","gt6hg")).thenReturn(2);
	     assertEquals(mockedRepo.findAllUsers("430","gt6hg"), 2);
	     
	     
	        
	      
		 
 
		
    }


}