pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'medail-api'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvnw.cmd clean package'
            }
        }

        stage('Docker Build') {
            steps {

                bat 'docker build -t %DOCKER_IMAGE% .'
            }
        }
    }
}
