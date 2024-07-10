pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/seu-usuario/seu-repositorio.git'
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