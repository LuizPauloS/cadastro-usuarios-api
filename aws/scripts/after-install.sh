#!/bin/bash
set -xe


# Copy jar file from S3 bucket to tomcat webapp folder
aws s3 cp s3://##s3-bucket##/cadastro-usuario-api-0.0.1-SNAPSHOT.jar /usr/local/tomcat9/webapps/cadastro-usuario-api-0.0.1-SNAPSHOT.jar


# Ensure the ownership permissions are correct.
chown -R tomcat:tomcat /usr/local/tomcat9/webapps