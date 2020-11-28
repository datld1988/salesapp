# Hướng dẫn:
1. Build thư viện common
# Vào thư mục .../salesapp/common-module và chạy lệnh sau:
mvn clean install

2. Tạo thư mục repository trong thư mục gốc của dự án (thư mục chứa file parent pom.xml)

3. Thêm dependencies không được quản lý vào dự án Maven
# Vào thư mục chứa file common-module.jar trong thư mục .../salesapp/common-module/target và chạy lệnh sau:
mvn deploy:deploy-file -Durl=file:////Volumes/DATA/VANQUANRAF/local/projects/companies/alphaway/sales-app/salesapp/repository -Dfile=common-module.jar -DgroupId=com.salesapp -DartifactId=common-module -Dpackaging=jar -Dversion=1.0-SNAPSHOT
# Hoặc build với đường dẫn tương đối như sau:
mvn deploy:deploy-file -Durl=file:../../repository -Dfile=common-module.jar -DgroupId=com.salesapp -DartifactId=common-module -Dpackaging=jar -Dversion=1.0-SNAPSHOT

4. Thêm khai báo repositories sau vào file parent pom.xml
	<repositories>
		<repository>
			<id>local-maven-repo</id>
			<url>file:///${project.basedir}/repository</url>
		</repository>
	</repositories>
	
5. Thêm khai báo dependency sau vào file pom.xml trong các module muốn sử dụng
    <dependency>
        <groupId>com.common</groupId>
        <artifactId>common-module</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    
