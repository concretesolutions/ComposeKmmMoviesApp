//
//  SelectModuleView.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 23/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct SelectModuleView: View {
    
    var body: some View {
        NavigationView {
            VStack(spacing: 30) {
                NavigationLink(
                    destination: MainView(manager: BuildModule.create(type: .native)),
                    label: {
                        Text("Native module")
                            .padding()
                            .background(Color.blue)
                            .foregroundColor(.white)
                            .cornerRadius(5)
                    })
                
                NavigationLink(
                    destination: MainView(manager: BuildModule.create(type: .kmm)),
                    label: {
                        Text("KMM module")
                            .padding()
                            .background(Color.blue)
                            .foregroundColor(.white)
                            .cornerRadius(5)
                    })
            }
        }
    }
}

struct SelectModuleView_Previews: PreviewProvider {
    static var previews: some View {
        SelectModuleView()
    }
}
