# Birthday service Spring Boot "Microservice"
This is a sample Java / Maven / Spring Boot application with two services Get (HTTP) and Put (HTTP).

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/rajasaran256/revolut-app.git
```

**2. Build the app using maven**

```bash
mvn clean install

```

**3. Build docker image**

```bash
docker build -t gcr.io/${PROJECT_ID}/birthday-service:v1 .

```

**4. Upload the docker image to GCR**

```bash
docker push gcr.io/${PROJECT_ID}/birthday-service:v1

```

**5. Deploy the application and Create a service**

```bash
kubectl apply -f StatefulSet.yaml
kubectl apply -f Service.yaml

```

##  Rest APIs

The app defines following APIs.

    PUT /hello/{name}

    GET /hello/{name}
