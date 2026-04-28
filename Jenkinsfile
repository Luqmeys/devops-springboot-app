pipeline {
    agent any

    environment {
        APP_NAME = 'student-app'
    }

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/Luqmeys/devops-springboot-app.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'     // ← Use bat here
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t ${APP_NAME}:latest ."
            }
        }

        stage('Run Container') {
            steps {
                bat '''
                    docker stop student-app || true
                    docker rm student-app || true
                '''
                bat "docker run -d -p 8080:8080 --name student-app ${APP_NAME}:latest"
            }
        }
    }
}