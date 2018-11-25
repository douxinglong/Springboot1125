package demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Aser {
@Bean("abc")
public Bser b() {
Bser bser=new Bser();
	return bser;
}
}
