import React, {Component} from 'react';
import {View, Text, Button} from 'react-native';
import {ToastExample} from "../../ToastExample";

class NativeModule extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <View>
                <Text>{'Native module'}</Text>
                <Button
                    title={'Native module'}
                    accessibilityLabel="Learn more about this purple button"
                    onPress={() => {
                        ToastExample.show('hello', ToastExample.SHORT)
                    }}
                />
            </View>
        );
    }
}

export default NativeModule
