# Makefile for Docker Compose commands

# Variables
COMPOSE_FILE := docker-compose.yml

# Default target
.PHONY: help
help:
	@echo "Available commands:"
	@echo "  make up-build    - Build and start the containers"
	@echo "  make down        - Stop the containers"
	@echo "  make down-v      - Stop the containers and remove volumes"
	@echo "  make up          - Start the containers without building"

# Build and start the containers
.PHONY: up-build
up-build:
	docker-compose -f $(COMPOSE_FILE) up -d --build springboot-app

# Stop the containers
.PHONY: down
down:
	docker-compose -f $(COMPOSE_FILE) down

# Stop the containers and remove volumes
.PHONY: down-v
down-v:
	docker-compose -f $(COMPOSE_FILE) down -v

# Start the containers without building
.PHONY: up
up:
	docker-compose -f $(COMPOSE_FILE) up -d