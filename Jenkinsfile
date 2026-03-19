pipeline {
    agent any

    environment {
        MAVEN = '/opt/homebrew/bin/mvn'   // adjust if needed
    }

    stages {

        stage('Build') {
            steps {
                sh "${MAVEN} clean compile"
            }
        }

        stage('Test') {
            steps {
                sh "${MAVEN} test"
            }
        }

        stage('Package') {
            steps {
                sh "${MAVEN} package -DskipTests"
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t myapp:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker stop myapp-container || true'
                sh 'docker rm myapp-container || true'
                sh 'docker run -d --name myapp-container -p 8080:8080 myapp:latest'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}
