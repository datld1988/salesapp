# Hướng dẫn add thư viện oracle:
1. Vào thư mục .../salesapp/libs/oracle và chạy lệnh sau:
mvn install:install-file \
   -Dfile=ojdbc7.jar \
   -DgroupId=com.oracle \
   -DartifactId=ojdbc7 \
   -Dversion=12.2.0.1 \
   -Dpackaging=jar \
   -DgeneratePom=true

2. Thêm khai báo dependency sau vào file pom.xml trong các module muốn sử dụng
    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc7</artifactId>
        <version>12.2.0.1</version>
    </dependency>
    
