# Hướng dẫn add thư viện common:
1. Vào thư mục .../salesapp/common-module và chạy lệnh sau:
mvn clean install

2. Vào thư mục .../salesapp/common-module/target và chạy lệnh sau:
mvn install:install-file \
   -Dfile=common-module.jar \
   -DgroupId=com.common \
   -DartifactId=common-module \
   -Dversion=1.0-SNAPSHOT \
   -Dpackaging=jar \
   -DgeneratePom=true

2. Thêm khai báo dependency sau vào file pom.xml trong các module muốn sử dụng
    <dependency>
        <groupId>com.common</groupId>
        <artifactId>common-module</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>compile</scope>
    </dependency>
    
