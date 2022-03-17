package it.epicode.be.energy.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
@OpenAPIDefinition(info = @Info(title = "Epic Energy Services API", version = "v1", description = "Epic Energy Services",
contact = @Contact(email = "samuel_91_@hotmail.it",name= "Samuel",url = "https://www.google.it")))
public class SwaggerConfig {

}
