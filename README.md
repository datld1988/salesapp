# Kiến trúc microservices trong hệ thống uniform:
1. Microservices core (các microservice nghiệp vụ của hệ thống uniform)
    - process service (domain hồ sơ khách hàng)
    - account service (domain tài khoản)
    - internet-banking service (domain internet banking)
    - card service (domain thẻ)
    - document service (domain tài liệu đính kèm)
    - report service (domain biểu mẫu)
    - process-history service (domain hồ sơ lịch sử)
    - management service (domain quản lý user, phân quyền)
    - email service (domain gửi thông báo:gửi mail, notification, vv)
    - log service (domain lưu trữ log khi call tới hệ thống bên ngoài)
2. Others (các microservice cần thiết phải có trong hệ thống)
    - registry service (registry các microservice)
    - gateway service (route & load balance & token relay)
    - auth service (central auth)
    - config service (central config)
    - monitoring service (pending)
# Run project theo thứ tự sau:
- config-server
- registry-service
- gateway-service
- các microservice nghiệp vụ

- models-service
- user-service
- process-service
- account-service
- ebank-service
- card-service
- attachment-service
- printout-service
- legal-service
- admin-service
- notification-service
- log-service
- kafka broker
- zipkin-server
- elastic-stack

