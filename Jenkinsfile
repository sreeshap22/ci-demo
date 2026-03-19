pipeline {
    agent any

    environment {
        MAVEN = '/opt/homebrew/bin/mvn'   // adjust if needed
    }
stage('Docker Build') {
    steps {
        sh '''
        export PATH=/Applications/Docker.app/Contents/Resources/bin:$PATH
        docker build -t myapp:latest .
        '''
    }
}

stage('Deploy') {
    steps {
        sh '''
        export PATH=/Applications/Docker.app/Contents/Resources/bin:$PATH
        docker stop myapp-container || true
        docker rm myapp-container || true
        docker run -d --name myapp-container -p 8080:8080 myapp:latest
        '''
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
