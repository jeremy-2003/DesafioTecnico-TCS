# DesafioTecnico-TCS
Este es un desafío técnico
*TENER EN CUENTA LO SIGUENTE*
Las monedas de tipo de cambio registradas estan como: USD, EUR y PEN
# Para ejecutar desde docker hacer los siguientes paso:
  - ./gradlew bootJar (Para buildear el proyecto)
  - docker build -t exchange . (Contruir la imagen)
  - docker run -p 8081:8081 exchange (Ejecutar el contenedor)
