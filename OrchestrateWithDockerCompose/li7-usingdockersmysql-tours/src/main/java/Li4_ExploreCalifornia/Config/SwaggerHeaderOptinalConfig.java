package Li4_ExploreCalifornia.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerHeaderOptinalConfig {

	@Bean
	OpenAPI swaggerHeader() {

		Info info = new Info();
		info
			.title("The Tour & Tour Ratings API")
			.description("This Project is created for Tours & Tour Ratings")
			.version("v3.0.0 Deep Version");

		return new OpenAPI().info(info);
	}

}
