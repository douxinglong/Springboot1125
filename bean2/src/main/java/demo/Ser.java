package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component("ser")
public class Ser {
	@Autowired
private User user;
public void dou() {
	System.out.println("2222222222");
	user.a();
}


}
