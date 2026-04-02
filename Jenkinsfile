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
                // Using .bat because Jenkins is running natively on Windows
                // This command cleans the target directory, runs tests, and packages the .jar
                bat 'mvnw.cmd clean package'
            }
        }

        stage('Docker Build') {
            steps {
                // Using %DOCKER_IMAGE% to reference environment variables in Windows bat
                bat 'docker build -t %DOCKER_IMAGE% .'
            }
        }
    }
}
