pipeline {
    agent any

    environment {
        APP_NAME = 'springboot-docker-demo'
        DOCKER_IMAGE = "saurabhkutwal/${APP_NAME}:${BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/ksaurabh97/springboot-docker-cicd.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh """
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push ${DOCKER_IMAGE}
                    """
                }
            }
        }

        stage('Deploy Container') {
            steps {
                script {
                    // Stop and remove any running container with same name
                    sh "docker rm -f ${APP_NAME} || true"
                    // Run a new one
                    sh "docker run -d -p 8080:8080 --name ${APP_NAME} ${DOCKER_IMAGE}"
                }
            }
        }
    }

    post {
        success {
            echo '🎉 Deployment Successful!'
        }
        failure {
            echo '❌ Pipeline Failed!'
        }
    }
}
