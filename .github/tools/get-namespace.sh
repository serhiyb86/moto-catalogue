#!/bin/bash

PWD=$(pwd)

HEAD_REF=$1
IMAGE_TAG=$($PWD/.github/tools/get-image-tag.sh $HEAD_REF)

SANITIZED_NAMESPACE=$(echo "$IMAGE_TAG" | sed 's/[^[:alnum:]\.\_\-]/-/g' | tr '[:upper:]' '[:lower:]' | tr ./_ - )

echo $SANITIZED_NAMESPACE