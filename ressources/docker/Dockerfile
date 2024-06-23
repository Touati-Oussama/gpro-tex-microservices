# Use the official GitLab Runner base image with Docker pre-installed
FROM gitlab/gitlab-runner:v15.8.2

# Update packages and install Docker
RUN apt-get update && apt-get install -y docker.io docker-compose

# Install Open JDK 17
RUN apt-get clean all && apt-get update && apt-get install -y openjdk-17-jdk

# Install Maven
RUN apt-get install -y maven

# Add GitLab Runner user to Docker group
RUN usermod -aG docker gitlab-runner
#COPY config.toml /etc/gitlab-runner/config.toml
# Register GitLab Runner

# Restart GitLab Runner (optional)
# Note: This is not typically done in a Dockerfile as it's a container setup step.
RUN gitlab-runner restart
EXPOSE 10000
EXPOSE 8668
EXPOSE 4444
EXPOSE 5656
EXPOSE 3434
EXPOSE 2323
EXPOSE 6767
EXPOSE 1200
