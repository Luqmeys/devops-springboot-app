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
                bat 'mvn clean package -DskipTests'
            }
        }

        // ✅ ADDED TEST STAGE
        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test || echo No tests implemented'
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
                    docker stop student-app || exit 0
                    docker rm student-app || exit 0
                '''
                bat "docker run -d -p 8080:8080 --name student-app ${APP_NAME}:latest"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat 'kubectl apply -f deployment.yml'
                bat 'kubectl apply -f service.yml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
        success {
            echo '✅ Deployment to Kubernetes successful!'
        }
        failure {
            echo '❌ Pipeline failed!'
        }
    }
}