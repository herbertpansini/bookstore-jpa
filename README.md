#BookStore

# instruções

$ docker-compose up -d

$ mvn clean install -DskipTests

$ mvn spring-boot:run -Drun.jvmArguments="-Xmx256m"

-> insert into tb_publisher values (gen_random_uuid(), 'Alta Books');
-> insert into tb_publisher values (gen_random_uuid(), 'Pearson');

-> insert into tb_author values (gen_random_uuid(), 'Eric Evans');
-> insert into tb_author values (gen_random_uuid(), 'Paul Deteil');
-> insert into tb_author values (gen_random_uuid(), 'Harvey Deteil');
