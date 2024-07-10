pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/mathns2803/jenkins-file-exercicio-5.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}