import React, {Component} from 'react';
import {createStackNavigator,} from 'react-navigation';
import Screen1 from './components/Screen1'
import NativeModule from './components/NativeModule'

class MainApp extends Component<> {
    render() {
        let MyScreen = createStackNavigator(
            {
                Screen1: {
                    screen: Screen1,
                    navigationOptions: {title: 'Screen1'},
                },
                NativeModule: {
                    screen: NativeModule,
                    navigationOptions: {title: 'NativeModule'},
                },
            }
        )
        return (
            <MyScreen/>
        );
    }
}

export default MainApp

