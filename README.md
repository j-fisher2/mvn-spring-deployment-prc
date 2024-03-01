**Binary Calculator Web Application**#<br>
This repository contains the files necessary to deploy a Binary Calculator web application using Docker and Kubernetes.<br>

Deployment Configuration<br>
The deployment of the Binary Calculator application is configured using Kubernetes manifests. The following Kubernetes resources are defined:<br>

Deployment: Defines the deployment configuration for the Binary Calculator application, specifying the number of replicas, container image, and ports.<br>
Service: Defines a service to expose the Binary Calculator application externally, configured as a LoadBalancer type service to allow access from outside the cluster.<br>

Dockerfile<br>
The Dockerfile in this repository provides instructions to build the Docker image for the Binary Calculator application. It specifies a base image, creates a volume for temporary files, copies the WAR file generated by Maven into the image, and configures the entrypoint to run the application.
