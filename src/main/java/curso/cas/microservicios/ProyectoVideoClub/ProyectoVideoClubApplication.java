package curso.cas.microservicios.ProyectoVideoClub;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.PrintStream;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class ProyectoVideoClubApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ProyectoVideoClubApplication.class, args);
		SpringApplication app = new SpringApplication(ProyectoVideoClubApplication.class);
		//app.setBannerMode(Banner.Mode.OFF);
		//app.setLogStartupInfo(false);
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.print("\n\n\tThis is my own banner!\n\n".toUpperCase());
			}
		});
		app.run(args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("curso.cas.microservicios.ProyectoVideoClub.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API")
				.description("VideoClub Management REST API")
				.contact(new Contact("David Robledo", "www.davidrobledo.es", "correo@davidrobledo.es"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}


}
