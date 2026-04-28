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
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Running basic tests..."'
                sh 'mvn test'   // or echo "No tests implemented" if none
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${APP_NAME}:latest ."
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker stop student-app || true'
                sh 'docker rm student-app || true'
                sh "docker run -d -p 8080:8080 --name student-app ${APP_NAME}:latest"
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
        success {
            echo '✅ Build and deployment successful!'
        }
    }
}
